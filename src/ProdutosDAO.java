import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        
        // conn = new conectaDAO().connectDB();
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }

    public void venderProduto(int idProduto) {

        String sql = "UPDATE produtos SET status = 'Vendido' WHERE id = ?";

        try {

            conn = new conectaDAO().connectDB();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, idProduto);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ProdutosDTO> listarProdutosVendidos(){

        ArrayList<ProdutosDTO> lista = new ArrayList<>();

        String sql = "SELECT * FROM produtos WHERE status = 'Vendido'";

        try {

            conn = new conectaDAO().connectDB();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){

                ProdutosDTO produto = new ProdutosDTO();

                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setStatus(rs.getString("status"));

                lista.add(produto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}