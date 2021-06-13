package br.com.gerenciador.usuario.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.gerenciador.usuario.model.ResultadoValidaUsuarioEnum;

@RestController
@RequestMapping("/users")
public class UserController {

	@Transactional
	@GetMapping(value = "/{cpf}")
	public ResponseEntity<?> validaCPF(@PathVariable @Valid String cpf) {

		CPFValidator cpfValidator = new CPFValidator();

		List<ValidationMessage> msgsErro = cpfValidator.invalidMessagesFor(cpf);
		if (msgsErro.size() == 0) {
			return ResponseEntity.ok(ResultadoValidaUsuarioEnum.ABLE_TO_VOTE);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new String("CPF '" + cpf + "' inválido."));
		}
	}
}
