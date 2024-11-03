package com.recursos_humanos_iudigital.controller;

import com.recursos_humanos_iudigital.data.FuncionarioDAO;
import com.recursos_humanos_iudigital.domain.Funcionario;
import java.sql.SQLException;
import java.util.List;

public class FuncionarioController {

    private FuncionarioDAO funcionarioDao;

    public FuncionarioController() {
        funcionarioDao = new FuncionarioDAO();
    }

    public List<Funcionario> obtenerFuncionario() throws SQLException {
        return funcionarioDao.obtenerFuncionarios();

    }

    public void crearFuncionario(Funcionario funcionario) throws SQLException {
        funcionarioDao.crear(funcionario);
    }

    public Funcionario obtenerFuncionarioPorId(int id) throws SQLException {
        return funcionarioDao.obtenerFuncionario(id);
    }

    public void actualizarFuncionario(int id, Funcionario funcionario) throws SQLException {
        funcionarioDao.actualizarFuncionario(id, funcionario);
    }

    public void eliminarFuncionario(int id) throws SQLException {
        funcionarioDao.eliminarFuncionario(id);
    }
}
