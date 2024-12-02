package service;

import repository.PacienteRepository;
import domain.Psicologo;
import domain.Paciente;
import ui.Menu;

public class CadastroPaciente {
    public static void main(String[] args) {

        PacienteRepository repository = new PacienteRepository();
        Menu menu = new Menu(repository);

        Psicologo Janaina = new Psicologo(
            "Janaina", 
            "janaina", 
            "senhaTeste123@", 
            "12345678", 
            "TCC"
        );
            
        Paciente Joao = new Paciente(
            1,                     
            "João",                
            "joao_login",          
            "Senha@123",           
            "12345678910",      
            "123456789",        
            "11912345678",     
            "Professor",           
            "Ensino Superior",     
            "Física",              
            "Carlos",              
            "Maria",               
            "Paciente com boa saúde.", 
            true               
        );

        menu.exibirLogin();
    }
}