package com.example.oppo.demo.domain;

import javax.persistence.*;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description  
 * @Author  zhaozheng
 * @Date 2019-02-19 
 */

@Setter
@Getter
@ToString
@Entity
public class Person  implements Serializable {

	private static final long serialVersionUID =  1907906513448244586L;

	@Id
	@GeneratedValue
	private Long id;

	/**
	 * 标签值
	 */
   	@Column(name = "tag_value" )
	private String tagValue;

	/**
	 * 标签映射
	 */
   	@Column(name = "tag_value_map" )
	private String tagValueMap;

	/**
	 * 标签ID
	 */
   	@Column(name = "tag_id" )
	private Long tagId;

	/**
	 * 标签百分百
	 */
   	@Column(name = "tag_value_distribution" )
	private Long tagValueDistribution;

}
