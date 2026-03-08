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
        
        //conn = new conectaDAO().connectDB();
        
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
}