package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CorreoDao;
import com.example.dao.EstudianteDao;
import com.example.entities.Correo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CorreoServiceImpl implements CorreoService {

    private final CorreoDao correoDao;
    private final EstudianteDao estudianteDao;

    @Override
    public List<Correo> dameCorreos(int idEstudiante) {
        // TODO Auto-generated method stub
        return correoDao.findByEstudiante(estudianteDao.findById(idEstudiante).get());
    }

    @Override
    public void eliminaCorreos(int idEstudiante) {
        // TODO Auto-generated method stub
        correoDao.deleteByEstudiante(estudianteDao.findById(idEstudiante).get());
    }

    @Override
    public void persistirCorreo(int idEstudiante, Correo correo) {
        // TODO Auto-generated method stub
        correo.setEstudiante(estudianteDao.findById(idEstudiante).get());
        correoDao.save(correo);
    }   

}
