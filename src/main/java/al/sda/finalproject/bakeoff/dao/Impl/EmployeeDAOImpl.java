package al.sda.finalproject.bakeoff.dao.Impl;

import al.sda.finalproject.bakeoff.dao.EmployeeDAO;
import al.sda.finalproject.bakeoff.dto.EmployeeDTO;
import al.sda.finalproject.bakeoff.entity.EmployeeEntity;
import al.sda.finalproject.bakeoff.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EmployeeDAOImpl implements EmployeeDAO {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeDAOImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeDTO> findAll() {

        return this.employeeRepository.findAll().stream().map(EmployeeDAOImpl::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO findById(Long id) {

        Optional<EmployeeEntity> employeeEntity = this.employeeRepository.findById(id);
        return employeeEntity.map(EmployeeDAOImpl::mapToDTO).orElse(null);

    }

    @Override
    public void save(EmployeeDTO employeeDTO) {

        this.employeeRepository.save(EmployeeDAOImpl.mapToEntity(employeeDTO));
    }

    @Override
    public void deleteById(Long id) {
        this.employeeRepository.deleteById(id);
    }

    public static EmployeeEntity mapToEntity(EmployeeDTO employeeDTO){
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setFirstName(employeeDTO.getFirstName());
        employeeEntity.setLastName(employeeDTO.getLastName());
        employeeEntity.setPosition(employeeDTO.getPosition());
        employeeEntity.setId(employeeDTO.getId());
        employeeEntity.setWage(employeeDTO.getWage());
        employeeEntity.setStartDate(employeeDTO.getStartDate());
        employeeEntity.setAccount(employeeDTO.getAccount());
        return employeeEntity;
    }

    public static EmployeeDTO mapToDTO(EmployeeEntity employeeEntity){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setAccount(employeeEntity.getAccount());
        employeeDTO.setStartDate(employeeEntity.getStartDate());
        employeeDTO.setId(employeeEntity.getId());
        employeeDTO.setFirstName(employeeEntity.getFirstName());
        employeeDTO.setPosition(employeeEntity.getPosition());
        employeeDTO.setLastName(employeeEntity.getLastName());
        employeeDTO.setWage(employeeEntity.getWage());
        return employeeDTO;
    }
}
