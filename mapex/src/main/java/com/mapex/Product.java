package com.mapex;

import java.util.Map;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyClass;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "val")
	@MapKeyClass(ComplexKey.class)
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="COMPLEXKEY", joinColumns= @JoinColumn(name = "product_id"))
	@AttributeOverrides({
		@AttributeOverride(name="key.name", column = @Column(name= "name")),
		@AttributeOverride(name="key.locale", column = @Column(name= "locale")),
	})
	private Map<ComplexKey, String> attributes; 
}
