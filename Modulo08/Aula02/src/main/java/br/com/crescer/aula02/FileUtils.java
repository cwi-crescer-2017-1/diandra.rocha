package br.com.crescer.aula02;
/**
 * @author carloshenrique
 */
public interface FileUtils {

    boolean mk(String string);

    boolean rm(String string);

    String ls(String string);

    boolean mv(String in, String out);
}