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
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/users")
public class UserController {

	@ApiOperation(value = "Valida se o CPF informado é válido. Caso positivo retorna ABLE_TO_VOTE.")
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = "Retorna ABLE_TO_VOTE"), //
			@ApiResponse(code = 404, message = "Retorna CPF_INVALIDO") })
	@Transactional
	@GetMapping(value = "/{cpf}", produces = { "application/json" })
	public ResponseEntity<ResultadoValidaUsuarioEnum> validaCPF(@PathVariable @Valid String cpf) {

		CPFValidator cpfValidator = new CPFValidator();

		List<ValidationMessage> msgsErro = cpfValidator.invalidMessagesFor(cpf);
		if (msgsErro.size() == 0) {
			return ResponseEntity.ok(ResultadoValidaUsuarioEnum.ABLE_TO_VOTE);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResultadoValidaUsuarioEnum.CPF_INVALIDO);
		}
	}
}
