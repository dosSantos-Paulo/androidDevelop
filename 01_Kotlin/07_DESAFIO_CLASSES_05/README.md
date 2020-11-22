# EXERCICIO 05

## Veículos Usados

Queremos desenvolver um sistema informático para uma concessionária deveículos usados. Essa concessionária decidiu que venderá apenas carros. Todos os carros têm:
- marca
- modelo
- ano de fabricação
- cor
- quilometragem

Como estratégia de marketing, a concessionária quer ter um registro dos clientes que compram os veículos. O departamento de marketing da concessionáriaprecisa saber o:
- nome
- sobrenome
- e alguma informação de contato dos clientes

Para poder oferecer outros carros no futuro.

Por outro lado, o departamento de contabilidade da concessionária quer ter um registro das vendas realizadas.
Cada registro deve ter as seguintes informações:
- valorDaVenda
- veiculoVendido
- cliente

1. Fazer um diagrama de classe representando o modelo que queremosimplementar.

2. Implementar cada classe e definir as propriedades. As classes que devem serimplementadas são:
- Concessionária
- Cliente
- Venda
- Veículo

3. Criar os construtores para as classes Cliente, Veículo e Venda.

- Cliente terá como parâmetros:
    - nome
    - sobrenome
    - contato

- Veículo terá como parâmetros
    - marca
    - modelo
    - ano de fabricação
    - cor
    - equilometragem
    
- Venda terá como parâmetros 
    - cliente
    - veículo
    - valor da venda
    
4. Definir, na classe Concessionária, a função registrarVenda(veículo: Veiculo,cliente: Cliente, valor: Double), que adiciona ao registro de vendas daconcessionária uma nova venda de um veículo a um cliente por um valor determinado.
