package com.iaito.config;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.iaito.model.VehicleDevice;
import com.iaito.service.ContainerMovementAtFixedReaderService;

@Configuration
public class MqttConfig {
	private static final Logger LOGGER = LoggerFactory.getLogger(MqttConfig.class);
	private static final String CHANNEL_NAME_IN = "mqttInboundChannel";
	private String url = "tcp://localhost:1883";
	private String consumerClientId = "mqttConsumer";
	private String consumerDefaultopic = "test";
	@Autowired SimpMessagingTemplate template;
	
	@Autowired ContainerMovementAtFixedReaderService movementService;
	
	/*
	 * List<ContainerAreaDTO> areaList;
	 * 
	 * @Bean public void initializeContainerAreas() { areaList = new ArrayList<>();
	 * areaList = containerAreaService.getAllContainerArea();
	 * 
	 * }
	 */

	@Bean
	public MqttConnectOptions getMqttConnectOptions() {
		MqttConnectOptions options = new MqttConnectOptions();
		options.setCleanSession(true);
		options.setServerURIs(new String[] { url });
		return options;
	}

	@Bean
	public MqttPahoClientFactory mqttClientFactory() {
		DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
		factory.setConnectionOptions(getMqttConnectOptions());
		return factory;
	}

	@Bean
	public MessageProducer inbound() {
		/*
		 * MqttPahoMessageDrivenChannelAdapter adapter = new
		 * MqttPahoMessageDrivenChannelAdapter(consumerClientId, mqttClientFactory(),
		 * new String[] { consumerDefaultopic });
		 */
		
		MyMqttPahoMessageDrivenChannelAdapter adapter = new MyMqttPahoMessageDrivenChannelAdapter(this, consumerClientId,
				mqttClientFactory(), new String[] { consumerDefaultopic });
		
		adapter.setCompletionTimeout(5000);
		adapter.setConverter(new DefaultPahoMessageConverter());
		adapter.setQos(1);
		adapter.setOutputChannel(mqttInboundChannel());
		
		return adapter;
	}
	@Bean(name = CHANNEL_NAME_IN)
	public MessageChannel mqttInboundChannel() {
		return new DirectChannel();
	}
	@Bean
	@ServiceActivator(inputChannel = CHANNEL_NAME_IN)
	public MessageHandler handler() {
		return new MessageHandler() {
			Gson gson = new Gson();
			@Override
			public void handleMessage(Message<?> message) throws MessagingException {
				ObjectMapper mapper = new ObjectMapper();
				try {
					LOGGER.info(message.toString());
					
					String msg = message.getPayload().toString();
					
					//System.out.println("############ "+msg);
					
					if(msg!=null && msg.charAt(0)=='#' && msg.charAt(msg.length()-1)=='&')
			         {		
			           msg=msg.substring(1, msg.length()-1);
			           String[] data = msg.split("[|]");
			           VehicleDevice vehicleDevice = new VehicleDevice();
			           vehicleDevice.setTagId(data[0]);
			           vehicleDevice.setLatitude(data[1]);
			           vehicleDevice.setLongitude(data[2]);
			           vehicleDevice.setAltitude(data[3]);
			           
			    		String tagdata = vehicleDevice.getTagId();
			    		tagdata = HextoAscii(tagdata.substring(6));
			    		 vehicleDevice.setTagId(tagdata);
			           System.out.println("############ "+vehicleDevice);
			           
			           template.convertAndSend("/topic/vehicleDeviceInformation", gson.toJson(vehicleDevice));

			           movementService.addContainerMovementAtRover(vehicleDevice);

			         }
					
					//VehicleDevice vehicleDevice = mapper.readValue((String)message.getPayload(), VehicleDevice.class);
					//LOGGER.error("{}", vehicleDevice.toString());
				    //LOGGER.info(vehicleDevice.toString());
					//template.convertAndSend("/topic/vehicleDeviceInformation", gson.toJson(vehicleDevice));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			
		};
	}
	
	
    public String HextoAscii(String hex){
        byte b[]=new byte[150];
        String ascii="";
        int counter=0,i=0;
        try{

            for(i=0;i<(hex.length());i=i+2,counter++){
                {

                    b[counter]=(byte)Integer.parseInt(hex.substring(i,i+2),16);
                }

            }// end of the for loop
        }catch(Exception ex){ascii="Error";}
        ascii=new String(b).substring(0,counter);
        return ascii;

    }
	
	/*
	 * @Bean public ApplicationListener<?> eventListener() { return new
	 * ApplicationListener<MqttConnectionFailedEvent>() {
	 * 
	 * @Override public void onApplicationEvent(MqttConnectionFailedEvent event) {
	 * //event.getCause().printStackTrace();
	 * 
	 * 
	 * LOGGER.info("ConnectionLost "+event.getCause()); }
	 * 
	 * }; }
	 */
	
	public void connectionLost()
	{
		LOGGER.info("####### Connection LOST");
	}
	public void reConnection()
	{
		LOGGER.info("$$$$$$$ Connected");
	}
}
