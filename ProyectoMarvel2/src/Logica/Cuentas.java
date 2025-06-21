/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author Nathan
 */
public class Cuentas {
    private Usuario[] usuarios;
    private int numUsuarios;
    private static final int MAX_USUARIOS = 100; 

    public Cuentas() {
        usuarios = new Usuario[MAX_USUARIOS];
        numUsuarios = 0; 
        System.out.println("Sistema de cuentas inicializado. Capacidad máxima: " + MAX_USUARIOS);
        
        // Crear usuarios de prueba para facilitar las pruebas
        crearUsuariosDePrueba();
    }
    
    private void crearUsuariosDePrueba() {
        // Crear usuario de prueba
        registrarUsuario("admin", "12345");
        Usuario usuarioPrueba = buscarUsuario("admin");
        if (usuarioPrueba != null) {
            // Añadir algunos juegos de ejemplo
            usuarioPrueba.registrojuegos(new juego("TERMINADO - 5/5 correctas", 500));
            usuarioPrueba.registrojuegos(new juego("TERMINADO - 3/5 correctas", 300));
            usuarioPrueba.registrojuegos(new juego("TERMINADO - 4/5 correctas", 400));
            usuarioPrueba.setPuntaje(1200);
            System.out.println("Usuario de prueba creado: admin/12345 con historial de partidos");
        }
    }

    public boolean registrarUsuario(String username, String password) {
        System.out.println("Intentando registrar usuario: '" + username + "' con contraseña de " + 
                          (password != null ? password.length() : 0) + " caracteres");
        
        // Validar entrada básica
        if (username == null || username.trim().isEmpty()) {
            System.out.println("ERROR: El nombre de usuario está vacío");
            return false;
        }
        
        if (password == null || password.trim().isEmpty()) {
            System.out.println("ERROR: La contraseña está vacía");
            return false;
        }
        
        // Limpiar espacios
        username = username.trim();
        password = password.trim();
        
        // Validar capacidad
        if (numUsuarios >= MAX_USUARIOS) {
            System.out.println("ERROR: Capacidad máxima alcanzada (" + MAX_USUARIOS + " usuarios)");
            return false;
        }

        // Validar longitud de contraseña
        if (password.length() != 5) {
            System.out.println("ERROR: La contraseña debe tener exactamente 5 caracteres. Actual: " + password.length());
            return false;
        }

        // Verificar usuario duplicado
        for (int i = 0; i < numUsuarios; i++) {
            if (usuarios[i] != null && usuarios[i].getUsuario().equalsIgnoreCase(username)) { 
                System.out.println("ERROR: El usuario '" + username + "' ya existe");
                return false;
            }
        }

        // Crear usuario
        try {
            usuarios[numUsuarios] = new Usuario(username, password);
            numUsuarios++;
            System.out.println("ÉXITO: Usuario '" + username + "' registrado. Total usuarios: " + numUsuarios);
            return true;
        } catch (Exception e) {
            System.out.println("ERROR: Fallo al crear usuario - " + e.getMessage());
            return false;
        }
    }

    public boolean verificarCredenciales(String username, String password) {
        System.out.println("Verificando credenciales para usuario: '" + username + "'");
        
        if (username == null || password == null) {
            System.out.println("ERROR: Credenciales nulas");
            return false;
        }
        
        for (int i = 0; i < numUsuarios; i++) {
            if (usuarios[i] != null && 
                usuarios[i].getUsuario().equals(username) && 
                usuarios[i].getContra().equals(password)) {
                System.out.println("ÉXITO: Credenciales válidas para '" + username + "'");
                return true;
            }
        }
        
        System.out.println("ERROR: Credenciales inválidas para '" + username + "'");
        return false;
    }
    
    public boolean cambiarcontra(String username, String currentPassword, String newPassword) {
        System.out.println("Cambiando contraseña para usuario: '" + username + "'");
        
        if (username == null || currentPassword == null || newPassword == null) {
            System.out.println("ERROR: Parámetros nulos");
            return false;
        }
        
        if (newPassword.trim().length() != 5) {
            System.out.println("ERROR: Nueva contraseña debe tener 5 caracteres");
            return false;
        }
        
        for (int i = 0; i < numUsuarios; i++) {
            if (usuarios[i] != null && usuarios[i].getUsuario().equals(username)) {
                if (usuarios[i].getContra().equals(currentPassword)) {
                    usuarios[i].setContra(newPassword.trim());
                    System.out.println("ÉXITO: Contraseña cambiada para '" + username + "'");
                    return true;
                } else {
                    System.out.println("ERROR: Contraseña actual incorrecta");
                    return false;
                }
            }
        }
        
        System.out.println("ERROR: Usuario no encontrado");
        return false;
    }
    
    public boolean eliminarUsuario(String username, String password) {
        System.out.println("Eliminando usuario: '" + username + "'");
        
        if (username == null || password == null) {
            System.out.println("ERROR: Parámetros nulos");
            return false;
        }
        
        for (int i = 0; i < numUsuarios; i++) {
            if (usuarios[i] != null && 
                usuarios[i].getUsuario().equals(username) && 
                usuarios[i].getContra().equals(password)) {
                
                // Mover usuarios hacia atrás
                for (int j = i; j < numUsuarios - 1; j++) {
                    usuarios[j] = usuarios[j + 1];
                }
                usuarios[numUsuarios - 1] = null;
                numUsuarios--;
                System.out.println("ÉXITO: Usuario '" + username + "' eliminado");
                return true;
            }
        }
        
        System.out.println("ERROR: Usuario no encontrado o contraseña incorrecta");
        return false;
    }
    
    public Usuario buscarUsuario(String username) {
        if (username == null) {
            return null;
        }
        
        for (int i = 0; i < numUsuarios; i++) {
            if (usuarios[i] != null && usuarios[i].getUsuario().equals(username)) {
                return usuarios[i];
            }
        }
        return null;
    }
    
    public int getNumUsuarios() {
        return numUsuarios;
    }
}


    

