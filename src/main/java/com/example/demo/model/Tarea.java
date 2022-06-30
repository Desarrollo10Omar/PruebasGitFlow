package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tareas")
public class Tarea {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "titulo")
	private String titulo;
	@Column(name = "description")
	private String description;
	@Column(name = "terminado")
	private boolean terminado;

    public Tarea(){}

    public Tarea(long id, String titulo, String description, boolean terminado) {
        this.id = id;
        this.titulo = titulo;
        this.description = description;
        this.terminado = terminado;
    }

    public Tarea(String titulo, String description, boolean terminado) {
        this.titulo = titulo;
        this.description = description;
        this.terminado = terminado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isTerminado() {
        return terminado;
    }

    public void setTerminado(boolean terminado) {
        this.terminado = terminado;
    }

}
