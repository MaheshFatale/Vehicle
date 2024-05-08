package in.ashokit.entity;

import java.time.LocalDate;

import org.apache.logging.log4j.message.TimestampMessage;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Vehical_table_Thymeleaf")
public class VehicalEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String passNo;
	private String sitter;
	private String mode;
	
	@CreationTimestamp
	@Column(name = "Creat",updatable = false)
	private LocalDate creatDate;
	
	@UpdateTimestamp
	@Column(name = "Last_Update",insertable = false)
	private LocalDate updateDate;
	
}