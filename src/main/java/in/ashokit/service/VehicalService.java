package in.ashokit.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import in.ashokit.binding.VehicalBinding;
import in.ashokit.entity.VehicalEntity;
import in.ashokit.repo.VehicalRepository;

@Service
public class VehicalService {

	@Autowired
	private VehicalRepository repo;
	
	public boolean saveVehical(VehicalBinding vb)
	{
		VehicalEntity entity=new VehicalEntity();
		BeanUtils.copyProperties(vb, entity);
		String st=Arrays.toString(vb.getMode());
		String st1=st.replace("[","");
		String st2=st1.replace("]","");
		entity.setMode(st2);
		
		//entity.setMode(Arrays.toString(vb.getMode()));
		repo.save(entity);
		return true;
	}
	
	public VehicalBinding findbyId(Integer id)
	{
		Optional<VehicalEntity>  v= repo.findById(id);
		VehicalEntity v1=v.get();
		VehicalBinding vb=new VehicalBinding();
		BeanUtils.copyProperties(v1, vb);
//		String st1[]=v1.getMode().split(",");
//		String st2[]= {"Dynamic","Eco","Comfort","Mud-Ruts","Sand","Rock Crawl"};
		vb.setMode(v1.getMode().split(","));  
		return vb;
	}
	
	public void deleteById(Integer id)
	{
		repo.deleteById(id);	
	}
	
	
	
	public List<String> getMode()
	{
		return Arrays.asList("Dynamic","Eco","Comfort","Mud-Ruts","Sand","Rock Crawl");
	}
	
	public List<String> getSitter()
	{
		return Arrays.asList("4 Sitter","5 Sitter","6 Sitter","7 Sitter","8 Sitter","9 Sitter","10 Sitter","11 Sitter","12 Sitter","13 Sitter");
	}
	
	public List<VehicalEntity> findAll()
	{
		return repo.findAll();
	}
	
}
