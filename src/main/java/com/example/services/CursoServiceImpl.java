package com.example.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dao.CursoDao;
import com.example.entities.Curso;
import com.example.entities.Estudiante;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements CursoService {

    private final CursoDao cursoDao;

    @Override
    public List<Curso> dameLosCursos() {
        // TODO Auto-generated method stub
        return cursoDao.findAll();
    }

    @Override
    public Curso dameUnCurso(int idCurso) {
        // TODO Auto-generated method stub
       return cursoDao.findById(idCurso).get();
    }

    @Override
    public void persistirCurso(Curso curso) {
        // TODO Auto-generated method stub
        cursoDao.save(curso);
    }
    

}
