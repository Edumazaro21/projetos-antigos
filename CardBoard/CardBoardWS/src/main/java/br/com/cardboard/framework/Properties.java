package br.com.cardboard.framework;

import java.io.File;
import java.io.FileInputStream;
import javax.swing.JOptionPane;

public class Properties {

    private static java.util.Properties oProperty = null;
    private static String file = "c:/cardboard/cardboard.properties";

    /**
     * Inicializa a classe carregando o arquivo VR.PROPERTIES
     */
    static {
        try {
            verficarProperties();

            FileInputStream oFile = new FileInputStream(new File(file));

            oProperty = new java.util.Properties();
            oProperty.load(oFile);

        } catch (Exception ex) {
            System.err.println(ex.getMessage());

        }
    }

    /**
     * Retorna o valor para a chave informada, fazendo o CAST para o tipo
     * informado.
     *
     * @param <T>
     * @param i_chave Chave a ser procurada no arquivo properties
     * @param i_tipo Classe utilizada para fazer o cast
     * @return
     */
    private static <T> T get(String i_chave, Class<T> i_tipo) {
        Object value = oProperty.get(i_chave);
        if (value == null) {
            return null;
        } else {
            return i_tipo.cast(value);
        }
    }

    /**
     * Retorna o valor para a chave informada, fazendo o CAST para o tipo
     * informado. Caso o valor n�o seja encontrado, ser� retornado o valor
     * padr�o informado no par�metro.
     *
     * @param <T> Qualquer classe
     * @param i_chave Chave a ser procurada no arquivo properties
     * @param i_tipo Classe utilizada para fazer o cast. Ex: Integer.TYPE,
     * Object.class
     * @param i_valorpadrao Valor padr�o a ser retornado caso a chave pesquisada
     * n�o exista.
     * @return Valor da chave encontrada, realizado o cast para o tipo
     * informado.
     */
    private static <T> T get(String i_chave, Class<T> i_tipo, T i_valorpadrao) {
        String value = oProperty.getProperty(i_chave, String.valueOf(i_valorpadrao)).trim();
        value = value.isEmpty() ? String.valueOf(i_valorpadrao) : value;

        if (i_tipo.isAssignableFrom(Integer.TYPE)) {
            return (T) Integer.valueOf(value);

        } else if (i_tipo.isAssignableFrom(Long.TYPE)) {
            return (T) Long.valueOf(value);

        } else if (i_tipo.isAssignableFrom(Boolean.TYPE)) {
            return (T) Boolean.valueOf(value);

        } else if (i_tipo.isAssignableFrom(Double.TYPE)) {
            return (T) Double.valueOf(value);

        } else {
            return (T) value;
        }

    }

    public static String getString(String i_propriedade) {
        return getString(i_propriedade, "");
    }

    public static String getString(String i_propriedade, String i_valorpadrao) {
        return get(i_propriedade, String.class, i_valorpadrao);
    }

    public static boolean getBoolean(String i_chave) {
        return getBoolean(i_chave, false);
    }

    public static boolean getBoolean(String i_chave, boolean i_valorpadrao) {
        return get(i_chave, Boolean.TYPE, i_valorpadrao);
    }

    public static int getInt(String i_chave) {
        return getInt(i_chave, 0);
    }

    public static int getInt(String i_chave, int i_valorpadrao) {
        return get(i_chave, Integer.TYPE, i_valorpadrao);
    }

    public static long getLong(String i_chave) {
        return getLong(i_chave, 0l);
    }

    public static long getLong(String i_chave, long i_valorpadrao) {
        return get(i_chave, Long.TYPE, i_valorpadrao);
    }

    public static double getDouble(String i_chave) {
        return getDouble(i_chave, 0d);
    }

    public static double getDouble(String i_chave, double i_valorpadrao) {
        return get(i_chave, Double.TYPE, i_valorpadrao);
    }

    public static void replace(String i_valor, String i_novoValor) {
        oProperty.replace(i_valor, i_novoValor);
    }

    public static void verficarProperties() throws Exception {
        try {
            if (!exists(file)) {

                JOptionPane.showInternalMessageDialog(null, "Arquivo Properties não encontrado!");
                        
                System.exit(0);
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }
    
    public static boolean propriedadeExiste(String i_chave) throws Exception {
        return oProperty.getProperty(i_chave) != null;
    }
    
    public static boolean exists(String i_arquivo) throws Exception {
        return new File(i_arquivo).exists();
    }

}


