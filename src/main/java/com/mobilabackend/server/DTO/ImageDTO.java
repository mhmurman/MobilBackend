package com.mobilabackend.server.DTO;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "image_dto")
public class ImageDTO {
    public ImageDTO() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "image", nullable = false)
    private Blob image;

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}