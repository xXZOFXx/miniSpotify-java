package VO;

import java.io.InputStream;

public class AudioVO {

    /*Todo los atributos*/
    int codigoaudio;
    String nombreaudio;
    private byte[] archivoaudioby;
    private InputStream archivoaudioin;

    public AudioVO() {
    }

    /*Todo los codigos get*/
    public int getCodigoaudio() {
        return codigoaudio;
    }

    public String getNombreaudio() {
        return nombreaudio;
    }


    /*Todo los codigos set*/
    public void setCodigoaudio(int codigoaudio) {
        this.codigoaudio = codigoaudio;
    }

    public void setNombreaudio(String nombreaudio) {
        this.nombreaudio = nombreaudio;
    }

    /**
     * @return the archivoaudio2
     */
    public InputStream getArchivoaudioin() {
        return archivoaudioin;
    }

    /**
     * @param archivoaudio2 the archivoaudio2 to set
     */
    public void setArchivoaudioin(InputStream archivoaudio2) {
        this.archivoaudioin = archivoaudio2;
    }

    /**
     * @return the archivoaudio
     */
    public byte[] getArchivoaudioby() {
        return archivoaudioby;
    }

    /**
     * @param archivoaudio the archivoaudio to set
     */
    public void setArchivoaudioby(byte[] archivoaudio) {
        this.archivoaudioby = archivoaudio;
    }

}
