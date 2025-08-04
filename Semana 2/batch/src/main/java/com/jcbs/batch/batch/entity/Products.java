package com.jcbs.batch.batch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ARTICULOS_INFO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {

    @Id
    @Column(name = "PRODUCTO_ID")
    private String id;
    @Column(name = "NOMBRE")
    private String name;
    @Column(name = "DESCRIPCION")
    private String description;
    @Column(name = "PRECIO")
    private double price;
    @Column(name = "TALLA")
    private String size;
    @Column(name = "CATEGORIA")
    private String category;
    @Column(name = "CANTIDAD")
    private int stock;
}
