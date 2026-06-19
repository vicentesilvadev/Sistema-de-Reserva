# Guia de Contribuição - Sistema de Reserva

Este documento estabelece as normas obrigatórias para o desenvolvimento do sistema de Reserva. O cumprimento destas regras é essencial para manter a organização das sprints e a qualidade das entregas.

## 1. Padronização de Mensagens (Conventional Commits)

Adotamos o padrão de commits técnicos para facilitar o rastreio de mudanças. Os commits devem ser frequentes e nunca acumular alterações de arquivos diferentes em uma única mensagem.

## Feat

**Use `feat` quando estiver criando classes novas, heranças ou novos atributos:**

* `feat(Cliente): criar classe Cliente com atributos nome e cpf`
* `feat(Conta): implementar encapsulamento com getters e setters`
* `feat(Funcionário): criar classe abstrata Funcionário`


---

## Fix

**Use `fix` para consertar erros em métodos ou falhas de lógica:**

* `fix(ContaBancária): corrigir bug no método sacar que aceitava valor negativo`
* `fix(Autenticação): resolver erro de NullPointerException ao validar senha`


---

## Refactor

**Use `refactor` quando o código já funciona, mas você resolveu aplicar um conceito para deixá-lo mais organizado:**

* `refactor(Gerente): aplicar herança estendendo a classe Funcionário`
* `refactor(Notificação): usar polimorfismo para métodos enviarMensagem`
* `refactor(Interface): substituir herança múltipla por implementação de Interfaces `


---

## Chore

**Use `chore` para a classe Main, configurações ou o fluxo do menu que testa o projeto:**

* `chore(Main): instanciar objetos no método principal para teste`


---

## Docs

**Use `docs` para alterações textuais que explicam o projeto**

* `docs(README): adicionar o diagrama de classes UML do projeto`
* `docs(Readme): descrever instruções de como rodar o projeto Java/Python`


---