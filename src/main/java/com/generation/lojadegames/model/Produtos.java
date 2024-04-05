package com.generation.lojadegames.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produtos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O Titulo é um campo obrigatório!")
	@Size(min = 2, max = 150, message = "O Nome deve conter no mínimo 02 e no máximo 150 caracteres!")
	private String titulo; 
	
	@NotBlank(message = "A Descrição é um campo obrigatório!")
	@Size(min = 5, max = 255, message = "A Descrição deve conter no mínimo 05 e no máximo 255 caracteres!")
	private String descricao;
	
	@Size(min = 2, max = 100, message = "O tipo de Console deve conter no mínimo 02 e no máximo 255 caracteres!")
	private String console;
	
	@NotNull (message = "É necessário informar a quantidade em estoque.")
	private Integer quantidade;
	
	@NotNull (message = "O campo preço é obrigatório!")
	@Column(precision = 8, scale = 2)
	private BigDecimal preco;
	
	@UpdateTimestamp
	private LocalDateTime dataCadastro;
	
	//Relacionamento entre tabelas
	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Categorias categorias;
	
	
	// Getters e Setters 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getConsole() {
		return console;
	}

	public void setConsole(String console) {
		this.console = console;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Categorias getCategorias() {
		return categorias;
	}

	public void setCategorias(Categorias categorias) {
		this.categorias = categorias;
	}
	
	
	
	
}
