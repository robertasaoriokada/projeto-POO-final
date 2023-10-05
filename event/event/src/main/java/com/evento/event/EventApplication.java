package com.evento.event;

// import java.util.Scanner;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// import com.evento.event.controllers.PessoaController;
// import com.evento.event.entities.Pessoa;
// import com.evento.event.repositories.CasamentoRepo;
// import com.evento.event.services.CasamentoService;

@SpringBootApplication
public class EventApplication {
	public static void main(String[] args) {
		SpringApplication.run(EventApplication.class, args);
		// PessoaController pessoaController = new PessoaController();
		// Scanner sc = new Scanner(System.in);
		// System.out.println("Hello, how are you?");
		// int operacao;
		
	
		// do{
		// 	System.out.println("1 - Cadastrar pessoas");
		// 	System.out.println("2 - Buscar uma pessoa");
		// 	System.out.println("3 - Listar todas as pessoas");
		// 	System.out.println("4 - Editar uma pessoa");
		// 	System.out.println("5 - Excluir uma pessoa");
		// 	System.out.println("6 - Cadastrar casamento");
		// 	System.out.println("7 - Buscar um casamento");
		// 	System.out.println("8 - Listar todos os casamentos");
		// 	System.out.println("9 - Editar um casamento");
		// 	System.out.println("10 - Excluir um casamento");
		// 	System.out.println("Qual operação você deseja fazer?");
		// 	operacao = sc.nextInt();
		// 	switch(operacao){
		// 		case 1:
		// 		System.out.println("Nome:");
		// 		String nome = sc.next();
		// 		System.out.println("Telefone:");
		// 		String telefone = sc.next();
		// 		System.out.println("RG:");
		// 		String rg = sc.next();
		// 		System.out.print(nome);
		// 		System.out.print(telefone);
		// 		System.out.print(rg);
		// 		Pessoa cadastro = new Pessoa(nome, telefone, rg);
		// 		pessoaController.createPessoa(cadastro);
		// 		break;
		// 		case 2:
		// 		System.out.println("Busque pelo id");
		// 		int id = sc.nextInt();
		// 		System.out.println(pessoaController.listarPessoaPeloId(id));
		// 		break;
		// 		// case 3: 
		// 		// System.out.println(pessoaController.listarPessoas());
		// 		// break;
		// 	}


		// }while(operacao != 0);
		// sc.close();
	
	}

}
