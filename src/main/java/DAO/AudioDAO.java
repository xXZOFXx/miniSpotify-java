package DAO;

import Conexion.Conectar;
import VO.AudioVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AudioDAO {

    /*Metodo listar*/
    public ArrayList<AudioVO> Listar_AudioVO() {
        ArrayList<AudioVO> list = new ArrayList<AudioVO>();
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM audio;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                AudioVO vo = new AudioVO();
                vo.setCodigoaudio(rs.getInt(1));
                vo.setNombreaudio(rs.getString(2));
                vo.setArchivoaudioby(rs.getBytes(3));
                list.add(vo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                conec.desconectar();
            } catch (Exception ex) {
            }
        }
        return list;
    }


    /*Metodo agregar*/
    public void Agregar_AudioVO(AudioVO vo) {
        Conectar conec = new Conectar();
        String sql = "INSERT INTO audio (codigoaudio, nombreaudio, archivoaudio) VALUES(?, ?, ?);";
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, vo.getCodigoaudio());
            ps.setString(2, vo.getNombreaudio());
            ps.setBytes(3, vo.getArchivoaudioby());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                conec.desconectar();
            } catch (Exception ex) {
            }
        }
    }


    /*Metodo Modificar*/
    public void Modificar_AudioVO(AudioVO vo) {
        Conectar conec = new Conectar();
        String sql = "UPDATE audio SET nombreaudio = ?, archivoaudio = ? WHERE codigoaudio = ?;";
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, vo.getNombreaudio());
            ps.setBytes(2, vo.getArchivoaudioby());
            ps.setInt(3, vo.getCodigoaudio());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                conec.desconectar();
            } catch (Exception ex) {
            }
        }
    }

    public void Modificar_AudioVO2(AudioVO vo) {
        Conectar conec = new Conectar();
        String sql = "UPDATE audio SET nombreaudio = ? WHERE codigoaudio = ?;";
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, vo.getNombreaudio());
            ps.setInt(2, vo.getCodigoaudio());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                conec.desconectar();
            } catch (Exception ex) {
            }
        }
    }


    /*Metodo Eliminar*/
    public void Eliminar_AudioVO(AudioVO vo) {
        Conectar conec = new Conectar();
        String sql = "DELETE FROM audio WHERE codigoaudio = ?;";
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, vo.getCodigoaudio());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                conec.desconectar();
            } catch (Exception ex) {
            }
        }
    }

    public AudioVO getAudioVOByIdby(int studentId) {
        AudioVO d = new AudioVO();
        Conectar db = new Conectar();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM audio WHERE codigoaudio = ?;";
        try {
            preparedStatement = db.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, studentId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //d.setCodigoaudio(resultSet.getInt(1));
                //d.setNombreaudio(resultSet.getString(2));
                d.setArchivoaudioby(resultSet.getBytes(3));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                db.desconectar();
            } catch (Exception ex) {
            }
        }
        return d;
    }

    public AudioVO getAudioVOByIdin(int studentId) {
        AudioVO d = new AudioVO();
        Conectar db = new Conectar();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM audio WHERE codigoaudio = ?;";
        try {
            preparedStatement = db.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, studentId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //d.setCodigoaudio(resultSet.getInt(1));
                //d.setNombreaudio(resultSet.getString(2));
                d.setArchivoaudioin(resultSet.getBinaryStream(3));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                db.desconectar();
            } catch (Exception ex) {
            }
        }
        return d;
    }

}
