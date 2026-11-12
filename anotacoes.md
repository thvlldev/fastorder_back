#05/11/2026

1.0 -- Tela home:

**GET de produtos ativos -> feito ,testado
**GET de produtos ativos por categoria -> ##FEITO E TESTADO
**GET de produto por nome, pra barra de busca -> adicionado, feito, testado
**GET de nome do usuario atual -> tirei, é o mesmo GET de usuario por id

1.1 -- Tela produto, ligada a home:

**GET de produto por id -> feito, testado

Ingredientes removíveis vão dentro da observação do item, sem tabela nova. Nota, avaliações e tempo estimado ficam fora do projeto.

2.0 -- Tela carrinho, finalizar pedido:

O carrinho fica só no front até confirmar, então os GETs de pedido saíram daqui.

**GET de endereco ativo por id do usuario -> feito, testado
**POST de criar pedido com itens -> adicionado, falta fazer
O app manda usuarioId, enderecoId, forma de pagamento e a lista de itens com produtoId, quantidade e observacao. O back define numero, data, status e total, com o preço vindo do banco. O Pedido ganha endereco, pagamento e taxa de entrega.

2.1 -- Login e cadastro:

**POST de cadastro de cliente com hash -> adicionado, feito, testado, em /cliente/criar-cliente
**POST de login -> adicionado, Feito Funcionando no Insomnia
**PUT de alterar senha -> adicionado, falta

2.2 -- Pedidos: confirmação, meus pedidos e acompanhar. Vieram do 2.0:

**GET de pedido por id, com os itens dentro -> falta
**GET de pedidos do usuario, não excluídos, mais recentes primeiro, com os itens dentro -> falta
**GET de itens_pedido por id do pedido -> tirei, os itens vêm dentro do pedido

3.0 -- Tela perfil:

**GET de usuario por id sem hash_senha -> feito, testado
**GET de cliente por id com telefone e pagamento -> adicionado, feito, testado

Telefone e pagamento já existiam no Cliente, e o PUT deles também, em /cliente/atualizar-cliente.

Falta fazer, em ordem:

    GET de produtos ativos por categoria
    POST de login
    PUT de alterar senha
    GET de pedido por id e GET de pedidos do usuario, com os itens dentro
    POST de criar pedido com itens

Pendências soltas:

Decidir a chave do ItemPedido, a composta não deixa o mesmo produto duas vezes no pedido com observações diferentes.
listar-clientes e o GET de endereços ainda devolvem o hash_senha, trocar por DTO.
O criar-usuario antigo grava a senha em texto puro.
E-mail único no banco.
