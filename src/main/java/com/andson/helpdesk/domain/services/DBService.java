package com.andson.helpdesk.domain.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andson.helpdesk.domain.Chamado;
import com.andson.helpdesk.domain.Cliente;
import com.andson.helpdesk.domain.Tecnico;
import com.andson.helpdesk.domain.enums.Perfil;
import com.andson.helpdesk.domain.enums.Prioridade;
import com.andson.helpdesk.domain.enums.Status;
import com.andson.helpdesk.repositories.ChamadoRepository;
import com.andson.helpdesk.repositories.ClienteRepository;
import com.andson.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {

    @Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;

    public void instanciaDB()
    {
        Tecnico tec1 = new Tecnico(null, "Andson Oliveira", "40926944070", "andson@email.com.br", "1234567");
		tec1.addPerfil(Perfil.ADMIN);
		Cliente cli1 = new Cliente(null, "José Cliente", "07526722076", "jose@email.com.br", "1234");

		Chamado ch1 = new Chamado(null, "Erro no Desktop", "Computador liga e não dá vídeo", Prioridade.MEDIA, Status.ANDAMENTO, tec1, cli1);

		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(ch1));
    }
}
