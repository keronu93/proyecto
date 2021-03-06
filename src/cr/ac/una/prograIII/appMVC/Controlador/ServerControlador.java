/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appMVC.Controlador;


import cr.ac.una.prograIII.appMVC.Vista.AgregarFactura;
import cr.ac.una.prograIII.appMVC.Vista.ManteArticulos;
import cr.ac.una.prograIII.appMVC.Vista.ManteCliente;
import cr.ac.una.prograIII.appMVC.Vista.Server;
import cr.ac.una.prograIII.appMVC.bl.ArticuloBL;
import cr.ac.una.prograIII.appMVC.bl.ClienteBL;
import cr.ac.una.prograIII.appMVC.bl.DetalleFacturaBL;
import cr.ac.una.prograIII.appMVC.bl.FacturaBL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Gustavo
 */
public class ServerControlador implements ActionListener, DocumentListener {

    private Server serverView;
    private AgregarFactura agregarFacturaView;
    ArrayList<ClienteHilo> listaClientes;
        
    /**
     *
     * @param serverView
     * @param listaClientes
     */
    public ServerControlador(Server serverView, ArrayList<ClienteHilo> listaClientes) {
        this.serverView = serverView;
        this.listaClientes = listaClientes;
        this.serverView.btDesbloquear.addActionListener(this);
        this.serverView.btDetenerServidor.addActionListener(this);
        this.serverView.btIniciarServidor.addActionListener(this);
        this.serverView.btLimpiarPantalla.addActionListener(this);
        this.serverView.btUsuariosEnLinea.addActionListener(this);
        this.serverView.BtBloquear.addActionListener(this);
        this.serverView.BtDesconectarPC.addActionListener(this);
        this.serverView.BtAgregarFactura.addActionListener(this);
       
                

    }

    /**
     *
     * @return
     */
    public AgregarFactura getAgregarFacturaView() {
        return agregarFacturaView;
    }

    /**
     *
     * @param agregarFacturaView
     */
    public void setAgregarFacturaView(AgregarFactura agregarFacturaView) {
        this.agregarFacturaView = agregarFacturaView;
    }

    /**
     *
     * @return
     */
    public Server getServerView() {
        return serverView;
    }

    /**
     *
     * @param serverView
     */
    public void setServerView(Server serverView) {
        this.serverView = serverView;
    }

    /**
     *
     * @return
     */
    public ArrayList<ClienteHilo> getListaClientes() {
        return listaClientes;
    }

    /**
     *
     * @param listaClientes
     */
    public void setListaClientes(ArrayList<ClienteHilo> listaClientes) {
        this.listaClientes = listaClientes;
    }
    


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.serverView.btIniciarServidor) {
            Thread starter = new Thread(new ServerStart());
            starter.start();
            serverView.Chat_Servidor.append("Servidor Iniciado...\n");
        }
        if (e.getSource() == this.serverView.btDetenerServidor) {
            try {
                Thread.sleep(2000);                 //2000 milliseconds is five second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            tellEveryone("Server:el servidor ha sido detenido y los usuarios se han desconectados.\n:Chat");
            serverView.Chat_Servidor.append("Servidor Detenido... \n");
            serverView.Chat_Servidor.setText("");
        }
        if (e.getSource() == this.serverView.btDesbloquear) {
            try {
                int fila = serverView.jTPC.getSelectedRow();
                String ipSeleccionada = serverView.jTPC.getValueAt(fila, 1).toString();
                String nombrePCSeleccionado = serverView.jTPC.getValueAt(fila, 0).toString();

            //*****************************************************
                //se recorre la lista de clientes y se verifica a cual
                //sokect se le quiere enviar el mensaja (el seleccionado 
                //en la tabla)
                //*****************************************************
                for (ClienteHilo cliente : listaClientes) {
                    //se optiene la IP del sokect para compararla con la seleccionada
                    String ipCliente = cliente.getSock().getInetAddress().toString();
                    if (ipCliente.equals(ipSeleccionada) && cliente.getNombrePC().endsWith(nombrePCSeleccionado)) {
                    //si el sokect es la tiene la ip seleccionada
                        //se le envia un mensaje
                        PrintWriter writer = new PrintWriter(cliente.getSock().getOutputStream());
                        
                        writer.println("Desbloqueado");
                        cliente.setEstadoActivo(true);
                        cliente.setHoInicio(cliente.horaInicio());
                        cliente.setHoFin("Sin definir");
                        cliente.setTiempo("Sin definir");
                        llenarTabla();
                        writer.flush();
                    }
                }
            } catch (Exception ex) {
                 //serverView.Chat_Servidor.append("Error no se puede desbloquear. \n");
                  JOptionPane.showMessageDialog(serverView, "Error no se puede desbloquear" , "Error Desbloqueando", JOptionPane.ERROR_MESSAGE);
            }

        }if (e.getSource() == this.serverView.BtBloquear) {
            try {
                int fila = serverView.jTPC.getSelectedRow();
                String ipSeleccionada = serverView.jTPC.getValueAt(fila, 1).toString();
                String nombrePCSeleccionado = serverView.jTPC.getValueAt(fila, 0).toString();
               
            //*****************************************************
                //se recorre la lista de clientes y se verifica a cual
                //sokect se le quiere enviar el mensaja (el seleccionado 
                //en la tabla)
                //*****************************************************
                for (ClienteHilo cliente : listaClientes) {
                    //se optiene la IP del sokect para compararla con la seleccionada
                    String ipCliente = cliente.getSock().getInetAddress().toString();
                    if (ipCliente.equals(ipSeleccionada) && cliente.getNombrePC().endsWith(nombrePCSeleccionado)) {
                    //si el sokect es la tiene la ip seleccionada
                        //se le envia un mensaje
                        PrintWriter writer = new PrintWriter(cliente.getSock().getOutputStream());
                        writer.println("Bloqueado");
                        cliente.setEstadoActivo(false);
                        cliente.setHoFin(cliente.horaFinal());
                        cliente.setTiempo(cliente.tiempoTotal());
                        llenarTabla();
                        
                        writer.flush();
                    }
                }
            } catch (Exception ex) {
                 //serverView.Chat_Servidor.append("Error no se puede bloquear. \n");
                  JOptionPane.showMessageDialog(serverView, "Error no se puede bloquear" , "Error Bloqueando", JOptionPane.ERROR_MESSAGE);
            }
        
        }if (e.getSource() == this.serverView.BtDesconectarPC) {
            try {
                int fila = serverView.jTPC.getSelectedRow();
                String ipSeleccionada = serverView.jTPC.getValueAt(fila, 1).toString();
                String nombrePCSeleccionado = serverView.jTPC.getValueAt(fila, 0).toString();

            //*****************************************************
                //se recorre la lista de clientes y se verifica a cual
                //sokect se le quiere enviar el mensaja (el seleccionado 
                //en la tabla)
                //*****************************************************
                for (ClienteHilo cliente : listaClientes) {
                    //se optiene la IP del sokect para compararla con la seleccionada
                    String ipCliente = cliente.getSock().getInetAddress().toString();
                    if (ipCliente.equals(ipSeleccionada) && cliente.getNombrePC().endsWith(nombrePCSeleccionado)) {
                    //si el sokect es la tiene la ip seleccionada
                        //se le envia un mensaje
                        PrintWriter writer = new PrintWriter(cliente.getSock().getOutputStream());
                        
                        writer.println("Desconectado");
                        listaClientes.remove(cliente);
//                        cliente.setEstadoActivo(true);
//                        cliente.setHoInicio(cliente.horaInicio());
//                        cliente.setHoFin("Sin definir");
//                        cliente.setTiempo("Sin definir");
                        llenarTabla();
                        writer.flush();
                    }
                }
            } catch (Exception ex) {
                 //serverView.Chat_Servidor.append("Error no se puede desbloquear. \n");
                JOptionPane.showMessageDialog(serverView, "Error no se puede desbloquear" , "Error Desbloqueando", JOptionPane.ERROR_MESSAGE);
            }

        }
        if (e.getSource() == this.serverView.btUsuariosEnLinea) {
             serverView.Chat_Servidor.append("\n Usuarios en Linea : \n");
             
        for (ClienteHilo cliente : listaClientes){
            serverView.Chat_Servidor.append("Cliente PC nombre:" +cliente.getNombrePC().toString());
           serverView.Chat_Servidor.append("\n");
        }    
//            for (ClienteHilo cliente : listaClientes) {
//                if (cliente.getEstadoActivo()) {
//                    System.out.println("Cliente PC nombre:" + cliente.getNombrePC().toString());
//                }
//            }
        }
        if (e.getSource() == this.serverView.btLimpiarPantalla) {
            serverView.Chat_Servidor.setText("");

        }
        if (e.getSource() == this.serverView.BtAgregarFactura) {
            
            int fila =this.serverView.jTPC.getSelectedRow();
            //Boolean estado=Boolean.parseBoolean(this.serverView.jTPC.getValueAt(fila, 2).toString());
            if (fila != -1) {  
            String tiempo=this.serverView.jTPC.getValueAt(fila, 5).toString();
            AgregarFactura manteFacturaView= new AgregarFactura();
            FacturaBL facturaBLModelo= new FacturaBL();
            DetalleFacturaBL detalleBLModelo= new DetalleFacturaBL();
            ManteCliente manteClienteView = new ManteCliente();
            ClienteBL clienteBLModelo= new ClienteBL();
            ManteArticulos manteArticuloView= new ManteArticulos();
            ArticuloBL articuloBLModelo= new ArticuloBL();
            FacturaControlador fControlador= new FacturaControlador(manteFacturaView,facturaBLModelo,manteClienteView,clienteBLModelo,manteArticuloView,articuloBLModelo,detalleBLModelo); 
            //Double t=Double.parseDouble(tiempo);
            //t=t/60;
            //tiempo=String.valueOf(t);
            manteFacturaView.txtCantidadArticulos.setText(tiempo);
            fControlador.getAgregarFacturaView().setVisible(true);
           
            }else{
                JOptionPane.showMessageDialog(serverView, "Error debe seleccionar una pc inactiva:", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     *
     */
    public void RetrasoSegundos() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

        }
     
    /**
     *
     */
    public class ServerStart implements Runnable {
        @Override
        public void run() {
            listaClientes = new ArrayList();
            
            try {
                ServerSocket serverSock = new ServerSocket(2222);
                while (true) {
                    //Cada ves que se acepta una conexion por socket
                    Socket clientSock = serverSock.accept();
                    //se crea un nuevo cliente
                    PrintWriter writer = new PrintWriter(clientSock.getOutputStream());
                    ClienteHilo cliente = new ClienteHilo(clientSock, writer);
                    listaClientes.add(cliente);
                    
                    //se crea un nuevo hilo para el nuevo socket creado, 
                    //independiente en otro hilo 
                    Thread listener = new Thread(cliente);
                    listener.start();
                    
                    //se llena la tabla con los clientes conectados
                    llenarTabla();
                    
                    serverView.Chat_Servidor.append("tienes una conexion \n" + clientSock.getInetAddress());
                   
                }
            } catch (Exception ex) {
                //serverView.Chat_Servidor.append("Error al realizar la conexión. \n");
                JOptionPane.showMessageDialog(serverView, "Error al realizar la conexión" , "Error realizando la conexión", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     *
     * @param message
     */
    public void tellEveryone(String message) {
        
        //*******************************************************
        //Se recorren todos los hilos y se le envia
        //un mensaje a cada uno
        //*******************************************************
        for (ClienteHilo cliente : listaClientes) {

            try {
                //Se toma el printWriter del sokect el cual es el que
                //permite el envio de mensajes
                PrintWriter writer = new PrintWriter(cliente.getSock().getOutputStream());
                writer.println(message);
                writer.flush();
                
                //Se muestra el mensaje en el texto
                serverView.Chat_Servidor.append("enviando: " + message + "\n");
                serverView.Chat_Servidor.setCaretPosition(serverView.Chat_Servidor.getDocument().getLength());

            } catch (Exception ex) {
                serverView.Chat_Servidor.append("Error al enviar mensaje a todos. \n");
                JOptionPane.showMessageDialog(serverView, "Error al enviar mensaje a todos" , "Error enviando mensajes", JOptionPane.ERROR_MESSAGE);
  
            }
        }
    }

   
    @Override
    public void insertUpdate(DocumentEvent e) {
        llenarTabla();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        llenarTabla();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        llenarTabla();
    }

    /**
     *
     */
    public void llenarTabla() {

        DefaultTableModel modeloTabla = new DefaultTableModel();
        serverView.jTPC.setModel(modeloTabla);
        String fila[] = new String[6];
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("IP");
        modeloTabla.addColumn("Estado");
        modeloTabla.addColumn("Hora Conexion");
        modeloTabla.addColumn("Hora Desconexion");
        modeloTabla.addColumn("Tiempo total");
        TableColumnModel columnModel = serverView.jTPC.getColumnModel();
        columnModel.getColumn(2).setPreferredWidth(80);

        try {
            //*************************************************
            //*************************************************
            //se recorre la lista de hilos para obtener la
            //información de los clientes conectados
            //*************************************************
            //*************************************************
            for (ClienteHilo cliente : listaClientes) {

                fila[0] = cliente.getNombrePC();
                fila[1] = cliente.getSock().getInetAddress().toString();
                fila[2] = cliente.getEstadoActivo().toString();
                fila[3] = cliente.getHoInicio();
                fila[4] = cliente.getHoFin();
                fila[5] = cliente.getTiempo();
                modeloTabla.addRow(fila); 
                
                
                
            }
            
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error (llenarTabla):" + ex.getMessage(), "Error en llenarTabla", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     *
     */
    public class ClienteHilo implements Runnable {

        private BufferedReader reader;
        private Socket sock;
        private PrintWriter printWriter;
        private String hoInicio = "";
        private String hoFin = "";
        private String tiempo="";
        private Boolean estadoActivo;
        private String nombrePC; 
        private Integer minuInicial;
        private Integer minuFinal;
        //Integer  MILLSECS_PER_DAY = 24*60;
        
        /**
         *
         * @param clientSocket
         * @param printWriter
         */
        public ClienteHilo(Socket clientSocket, PrintWriter printWriter) {
            
            this.printWriter = printWriter;
            this.estadoActivo = true;
            this.hoInicio=horaInicio();
            try {
                sock = clientSocket;
                InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(isReader);
            } catch (Exception ex) {
                serverView.Chat_Servidor.append("inesperado error... \n");
            }

        }
        
        
      
        @Override
        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    //*****************************************************
                    //El mensaje se muestra en el Texto de mensajes
                    //aca se deberia codificar que se quiere hacer
                    //*****************************************************
                    serverView.Chat_Servidor.append("Recibido: " + message + "\n");

                    //Se decodifica el mensaje
                    String mensajeEnPartes[] = message.split(":");
                    if (mensajeEnPartes[0].equals("N")) {//nuevo usuario
                        this.nombrePC = mensajeEnPartes[1];
                        llenarTabla();// se llena la tabla de clientes
                    }
                    
                }
            } catch (Exception ex) {
                serverView.Chat_Servidor.append("conexion perdida. \n");
                ex.printStackTrace();
            }
        }

        /**
         *
         * @return
         */
        public BufferedReader getReader() {
            return reader;
        }

        /**
         *
         * @param reader
         */
        public void setReader(BufferedReader reader) {
            this.reader = reader;
        }

        /**
         *
         * @return
         */
        public Socket getSock() {
            return sock;
        }

        /**
         *
         * @param sock
         */
        public void setSock(Socket sock) {
            this.sock = sock;
        }

        /**
         *
         * @return
         */
        public PrintWriter getPrintWriter() {
            return printWriter;
        }

        /**
         *
         * @param printWriter
         */
        public void setPrintWriter(PrintWriter printWriter) {
            this.printWriter = printWriter;
        }

        /**
         *
         * @return
         */
        public String getHoInicio() {
            return hoInicio ;
           
        }

        /**
         *
         * @param hoInicio
         */
        public void setHoInicio(String hoInicio) {
            this.hoInicio = hoInicio;
        }

        /**
         *
         * @return
         */
        public String getHoFin() {
            return hoFin;
        }

        /**
         *
         * @param hoFin
         */
        public void setHoFin(String hoFin) {
            this.hoFin = hoFin;
        }

        /**
         *
         * @return
         */
        public Boolean getEstadoActivo() {
            return estadoActivo;
        }

        /**
         *
         * @param estadoActivo
         */
        public void setEstadoActivo(Boolean estadoActivo) {
            this.estadoActivo = estadoActivo;
        }

        /**
         *
         * @return
         */
        public String getNombrePC() {
            return nombrePC;
        }

        /**
         *
         * @param nombrePC
         */
        public void setNombrePC(String nombrePC) {
            this.nombrePC = nombrePC;
        }

        /**
         *
         * @return
         */
        public String getTiempo() {
            return tiempo;
        }

        /**
         *
         * @param tiempo
         */
        public void setTiempo(String tiempo) {
            this.tiempo = tiempo;
        }

        /**
         *
         * @return
         */
        public Integer getMinuInicial() {
            return minuInicial;
        }

        /**
         *
         * @param minuInicial
         */
        public void setMinuInicial(Integer minuInicial) {
            this.minuInicial = minuInicial;
        }

        /**
         *
         * @return
         */
        public Integer getMinuFinal() {
            return minuFinal;
        }

        /**
         *
         * @param minuFinal
         */
        public void setMinuFinal(Integer minuFinal) {
            this.minuFinal = minuFinal;
        }
       
        /**
         *
         * @return
         */
        public String horaInicio(){
            String hora;
            Calendar calendario = Calendar.getInstance();
            String hoIn = String.valueOf(Calendar.getInstance().get(Calendar.HOUR));
            String miIn = String.valueOf(Calendar.getInstance().get(Calendar.MINUTE));
            hora= hoIn+" : " + miIn;
            int x=Integer.parseInt(hoIn);
            int y=Integer.parseInt(miIn);
            this.setMinuInicial((x*60)+y);
            return hora;    
        }
        
        /**
         *
         * @return
         */
        public String horaFinal(){
            String hora;
            Calendar calendario = Calendar.getInstance();
            String hofin = String.valueOf(Calendar.getInstance().get(Calendar.HOUR));
            String mifin = String.valueOf(Calendar.getInstance().get(Calendar.MINUTE));
            hora= hofin+" : " + mifin;
            int x=Integer.parseInt(hofin);
            int y=Integer.parseInt(mifin);
            this.setMinuFinal((x*60)+y);
            return hora;
        }
        
        /**
         *
         * @return
         */
        public String tiempoTotal(){
            String minutos;
            minutos=String.valueOf(this.getMinuFinal()-this.getMinuInicial());
            return minutos;
        }
        

    }
    
}
