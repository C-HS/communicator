package com.iaito.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "authority")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Enumerated(EnumType.STRING)
    private AuthorityType name;
    public Authority(AuthorityType authType){
        this.name = authType;
    }
}
