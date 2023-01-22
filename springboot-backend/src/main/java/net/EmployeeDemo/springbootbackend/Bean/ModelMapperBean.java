package net.EmployeeDemo.springbootbackend.Bean;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;

@Configuration
public class ModelMapperBean {

    // @Bean
    //  public ModelMapper modelMapperBean(){
    //    return new ModelMap();
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
