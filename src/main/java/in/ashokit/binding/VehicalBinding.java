package in.ashokit.binding;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class VehicalBinding {
	
	private Integer id;
	
	@NotBlank(message="Name is Mandatory")
	@Size(min=4,max=16,message="Name size 4 To 16")
	private String name;
	
	@NotBlank(message="Select 1 or More")
	private String[] mode;
	
	@NotBlank(message="Passing No is Mandatory")
	@Size(min=14,max=14,message="Enter Like -> MH 23 MF 21621")
	private String passNo;
	@NotBlank(message="Select any 1")
	private String sitter;
	
	@CreationTimestamp
	@Column(name = "Creat",updatable = false)
	private LocalDate creatDate;
	
	@UpdateTimestamp
	@Column(name = "Last_Update",insertable = false)
	private LocalDate updateDate;

}
