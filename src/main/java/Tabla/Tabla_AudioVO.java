package Tabla;

import DAO.AudioDAO;
import VO.AudioVO;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Tabla_AudioVO {

    AudioDAO dao = null;

    public void visualizar_AudioVO(JTable tabla) {

        tabla.setDefaultRenderer(Object.class, new Render());

        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        dt.addColumn("id");
        dt.addColumn("Nombre");
        dt.addColumn("Escuchar");
        dt.addColumn("Descargar");

        dao = new AudioDAO();
        ArrayList<AudioVO> list = dao.Listar_AudioVO();

        ImageIcon img = null;
        if (get_Image("/home/zof-pc/NetBeansProjects/musica/src/main/java/Imagen/Descargar.png") != null) {
            img = new ImageIcon(get_Image("/home/zof-pc/NetBeansProjects/musica/src/main/java/Imagen/Descargar.png"));
        }

        ImageIcon img2 = null;
        if (get_Image("/Imagen/Descargar.png") != null) {
            img2 = new ImageIcon(get_Image("/Imagen/Descargar.png"));
        }

        JButton btnaudio = new JButton("");
        btnaudio.setName("a");

        JButton btnd = new JButton("");
        btnd.setName("d");

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object fila[] = new Object[4];
                AudioVO vo = new AudioVO();
                vo = list.get(i);
                fila[0] = vo.getCodigoaudio();
                fila[1] = vo.getNombreaudio();

                try {
                    byte[] bi = vo.getArchivoaudioby();
                    InputStream in = new ByteArrayInputStream(bi);
                    if (in.read() > 0) {
                        JButton bta = new JButton();
                        btnaudio.setIcon(img);
                        fila[2] = btnaudio;
                        btnd.setIcon(img2);
                        fila[3] = btnd;
                    } else {
                        //btnaudio.setText("Sin audio");
                        //fila[2] = btnaudio;
                    }
                } catch (Exception ex) {
                    //System.out.println("VERSION 2: " + i + "" + ex.getMessage());
                    //ex.printStackTrace();
                    JButton mbt = new JButton();
                    mbt.setName("er1");
                    mbt.setText("S.A");
                    fila[2] = mbt;
                    JButton ag = new JButton();
                    ag.setName("er2");
                    ag.setText("N.D");
                    fila[3] = ag;
                }

                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(32);
            tabla.getColumnModel().getColumn(0).setMaxWidth(32);
            tabla.getColumnModel().getColumn(1).setMaxWidth(300);
            tabla.getColumnModel().getColumn(2).setMaxWidth(150);
            tabla.getColumnModel().getColumn(3).setMaxWidth(150);
        }
    }

    public Image get_Image(String ruta) {
        try {
            ImageIcon imageIcon = new ImageIcon(getClass().getResource(ruta));
            Image mainIcon = imageIcon.getImage();
            return mainIcon;
        } catch (Exception e) {
        }
        return null;
    }

}
