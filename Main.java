
import java.io.IOException;
import br.newtonpaiva.dominio.*;
import br.newtonpaiva.dominio.frete.*;
import br.newtonpaiva.dominio.imposto.*;
import br.newtonpaiva.dominio.geradorArquivo.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewSuppliesCompanyPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Categoria c1 = new Categoria();
        c1.setNome("Jogos");

        Produto p1 = new Produto();
        p1.setNome("Teclado");
        p1.setPreco(143.99);
        p1.setCategoria(c1);

        Produto p2 = new Produto();
        p2.setNome("Mouse");
        p2.setPreco(89.99);
        p2.setCategoria(c1);

        c1.getProdutos().add(p1);
        c1.getProdutos().add(p2);

        em.persist(c1);
        em.getTransaction().commit();

        em.getTransaction().begin();
        Categoria c2 = new Categoria();
        c2.setNome("SmartTV");
        em.persist(c2);
        em.getTransaction().commit();
        //em.getTransaction().rollback();

        em.close();
        emf.close();

        Cliente c = new Cliente();
        c.setNome("Daniel");

        /*
    PedidoBuilder builder = new PedidoBuilder();
    builder.addProduto(p1, 2);
    builder.addProduto(p2, 1);
    builder.setCliente(c);
    builder.setEnderecoEntrega(new Endereco("MG", "Contagem", "Europa", "32.155-054", "Rua teste", "1987"));
    
    Pedido p = builder.getResultado();
         */
        Pedido p = new PedidoBuilder()
                .addProduto(p1, 2)
                .addProduto(p2, 1)
                .setCliente(c)
                .setEnderecoEntrega(new Endereco("MG", "Contagem", "Europa", "32.155-054", "Rua teste", "1987"))
                .getResultado();

        System.out.println(p);

        try {
            GeradorArquivo file = new GeradorArquivoXML();
            file.gerar("teste.xml", p);

            file = new GeradorArquivoJSON();
            file.gerar("teste.json", p);

            file = new GeradorArquivoXMLCripto();
            file.gerar("teste.xml.cripto", p);

            file = new GeradorArquivoXMLCompactado();
            file.gerar("teste.xml.zip", p);

        } catch (IOException e) {
            e.printStackTrace();
        }


        /*
    ItemPedido i1 = new ItemPedido();
    i1.setPreco(p1.getPreco());
    i1.setQuantidade(2);
    i1.setProduto(p1);


    Pedido p = new Pedido(100);
    //p.setCalculoFrete(new FreteMG());
    //p.setCalculoImposto(new ImpostoMG());

    p.setCalculoFrete(new FreteRJ());
    p.setCalculoImposto(new ImpostoRJ());

    //p.setCalculoFrete(new FreteES());
    //p.setCalculoImposto(new ImpostoES());

    p.getItens().add(i1);
    p.setCliente(c);



    System.out.println("Valor total do pedido = " + p.obterTotal());
         */
    }
}
