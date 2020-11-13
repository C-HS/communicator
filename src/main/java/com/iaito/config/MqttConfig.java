package com.iaito.config;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.geotools.geojson.geom.GeometryJSON;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.event.MqttConnectionFailedEvent;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.iaito.dto.ContainerAreaDTO;
import com.iaito.model.VehicleDevice;
import com.iaito.service.ContainerAreaService;

@Configuration
public class MqttConfig {
	private static final Logger LOGGER = LoggerFactory.getLogger(MqttConfig.class);
	private static final String CHANNEL_NAME_IN = "mqttInboundChannel";
	private String url = "tcp://localhost:1883";
	private String consumerClientId = "mqttConsumer";
	private String consumerDefaultopic = "test";
	@Autowired SimpMessagingTemplate template;
	
	@Autowired ContainerAreaService containerAreaService;
	
	List<ContainerAreaDTO> areaList;
	
	@Bean
	public void initializeContainerAreas()
	{
	    areaList = new ArrayList<>();
        areaList = containerAreaService.getAllContainerArea();
		
	}

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
					
					String msg = message.toString();
					
					/*if(msg!=null && msg.charAt(0)=='#' && msg.charAt(msg.length()-1)=='&')
			         {
			           msg=msg.substring(1, msg.length()-1);
			           String[] data = msg.split("[|]");
			           
			          
			           VehicleDevice vehicleDevice = new VehicleDevice();
			           vehicleDevice.setTagId(data[0]);
			           vehicleDevice.setLatitude(data[1]);
			           vehicleDevice.setLongitude(data[2]);
			           vehicleDevice.setAltitude(data[3]);
			           template.convertAndSend("/topic/vehicleDeviceInformation", gson.toJson(vehicleDevice));
			           
			           GeometryJSON g = new GeometryJSON();
			           GeometryFactory gf = new GeometryFactory();
			           for(ContainerAreaDTO ca : areaList)
			           {
			        	   org.locationtech.jts.geom.Polygon polygon = g.readPolygon(ca.getAreaJson());
			        	   boolean pointIsInPolygon = polygon.contains(
			        			   gf.createPoint(
			        					   new Coordinate(
			        							   Double.parseDouble(vehicleDevice.getLatitude()),Double.parseDouble(vehicleDevice.getLongitude()))));
			        	   
			        	   if(pointIsInPolygon)
			        	   {
			        		   LOGGER.info("#################### "+ca.getAreaName());
			        	   }
			        	   
			           }
			           
			           
			         }*/
					
					//VehicleDevice vehicleDevice = mapper.readValue((String)message.getPayload(), VehicleDevice.class);
					//LOGGER.error("{}", vehicleDevice.toString());
				//	LOGGER.info(vehicleDevice.toString());
					//template.convertAndSend("/topic/vehicleDeviceInformation", gson.toJson(vehicleDevice));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			
		};
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
