package controller;

import javax.swing.JOptionPane;

public class DistroController {
    
    // Nome do SO
    private static String getOS() {
        return System.getProperty("os.name");
    }
    
    public static void exibeDistro() {
        String osName = getOS();
        
        // Ver se o SO é Linux
        if (osName.toLowerCase().contains("linux")) {
          
        	// distribuição 
            String command = "cat /etc/*release";
            
            try {
                Process process = Runtime.getRuntime().exec(command);
                java.util.Scanner scanner = new java.util.Scanner(process.getInputStream()).useDelimiter("\\A");
                String output = scanner.hasNext() ? scanner.next() : "";
                System.out.println(output);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Este programa suporta apenas sistemas Linux.");
        }
    }
}
