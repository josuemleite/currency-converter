# Índice

* [Introdução](#challenge-one---conversor-de-moeda)
* [Funcionalidades e Demonstração da Aplicação](#funcionalidades-e-demonstração-da-aplicação)
* [Acesso ao Projeto](#acesso-ao-projeto)
* [Tecnologias Utilizadas](#tecnologias-utilizadas)

# Challenge ONE - Conversor de Moeda

---

Neste emocionante desafio de programação, convidamos você a construir o seu próprio Conversor de Moedas. Você aprenderá a fazer requisições a uma API de taxas de câmbio, a manipular dados JSON e, por fim, a filtrar e exibir as moedas de interesse. Prepare-se para uma experiência prática e empolgante no desenvolvimento Java!

## Objetivo

---

Desenvolver um Conversor de Moedas que ofereça interação textual (via console) com os usuários, proporcionando no mínimo 6 opções distintas de conversões de moedas em um menu. A taxa de conversão não será estática, mas sim dinamicamente obtida por meio de uma API, garantindo dados precisos e em tempo real para uma experiência mais atualizada e eficaz.

# Funcionalidades e Demonstração da Aplicação

---

O Conversor de Moedas permite, com a utilização de uma API, consultar o valor da conversão de diferentes moedas de forma atualizada. Além das opções comuns disponibilizadas, o usuário pode verificar a conversão de outras moedas, bastando para isso inserir o respectivo código de três letras da(s) moeda(s) em questão conforme ISO 4217.

# Acesso ao Projeto

---

O projeto foi desenvolvido tendo como base a ExchangeRate-API para a conversão dos valores monetários.

Portanto, é necessário criar um arquivo `secure.properties` na raiz do projeto (dentro da pasta `src`) e inserir o a chave da API.

```
API_KEY=YOUR-API-KEY
```

Caso seja utilizada outra API, será necessário adequar o programa aos parâmetros entregues como resposta pela nova interface.

Exposta essa observação, para acessar a aplicação basta cloná-la em uma máquina com o `git` ou baixá-la diretamente pelo GitHub e então executá-la, de preferência com alguma IDE (caso queira mais desafio, execute os arquivos .java em bash com o comando `javac` e então os bytecodes gerados com o comando `java`).

# Tecnologias Utilizadas

---

Esta aplicação foi desenvolvida utilizando Java 17 (17.0.6) e a ExchangeRate-API.

