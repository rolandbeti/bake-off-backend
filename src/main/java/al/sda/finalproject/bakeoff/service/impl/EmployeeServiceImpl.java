package al.sda.finalproject.bakeoff.service.impl;

import al.sda.finalproject.bakeoff.dao.EmployeeDAO;
import al.sda.finalproject.bakeoff.dto.EmployeeDTO;
import al.sda.finalproject.bakeoff.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO){this.employeeDAO = employeeDAO;}

    @Override
    public List<EmployeeDTO> findAll() {
        return this.employeeDAO.findAll();
    }

    @Override
    public EmployeeDTO findById(Long id) {
        return this.employeeDAO.findById(id);
    }

    @Override
    public void save(EmployeeDTO employeeDTO) {
        this.employeeDAO.save(employeeDTO);
    }

    @Override
    public void deleteById(Long id) {
        this.employeeDAO.deleteById(id);
    }
}
