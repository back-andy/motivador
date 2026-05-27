# 🧠 Motivador (Nome Provisório) - Backend Core

O **Motivador** é um ecossistema de gerenciamento de rotina e tarefas projetado especificamente para acessibilidade cognitiva, com foco em neurodivergências como TDAH e Autismo. O objetivo principal é utilizar mecânicas de gamificação saudável para gerar engajamento e consistência, mitigando ativamente a parálise por análise e a ansiedade induzida por ferramentas tradicionais de produtividade.

Ao contrário de plataformas com abordagens baseadas no medo da perda (*loss aversion*), o **Motivador** implementa um design focado em "Rampas de Recuperação" e acolhimento humano.

---

## 🛠️ Stack Técnica

* **Linguagem:** Java 17+ (utilizando Java Records para imutabilidade e concisão)
* **Framework:** Spring Boot 3.x
* **Persistência & Banco de Dados:** Spring Data JPA / Hibernate | MySQL
* **Segurança:** Spring Security + Autenticação Stateless baseada em Tokens JWT
* **Validação:** Jakarta Bean Validation (assegurando integridade das payloads na borda da aplicação)

---

## 🏗️ Arquitetura e Boas Práticas

* **DTO Pattern:** Separação estrita entre o modelo de dados da persistência (`Entities`) e os contratos de entrada/saída (`DTOs`/`Records`) com validações específicas de borda (`@NotBlank`, `@Email`, etc.).
* **Global Exception Handling:** Centralização do tratamento de exceções com `@ControllerAdvice` para garantir respostas de API limpas, padronizadas e sem vazamento de stacktraces.
* **Agendamento de Tarefas:** Implementação de rotinas automáticas via `@Scheduled` do Spring para virada de ciclo diário/semanal e processamento de regras em background.

---

## 🧠 Mecânicas de Gamificação (Regras de Negócio Core)

### 1. Quebra de Carga Cognitiva (Tarefas e Subtarefas)
Grandes metas geram parálise por análise. O sistema força a granularidade:
* **Entidade Tarefa:** Relacionamento `1:N` com **Subtarefas**.
* **Porcentagem Reativa:** A conclusão de cada subtarefa atualiza em tempo real o progresso da tarefa mãe no banco de dados.
* **Dopamina em Micro-doses:** O ganho de XP é fracionado pelas subtarefas, premiando o progresso contínuo.

### 2. Linhas de Defesa contra o Esgotamento
Mecânica antitrabalho forçado que protege o *streak* (ofensiva) do usuário em dias de crise:
* **Defesa Passiva (Escudos):** Teto de até 3 Escudos. Se o ciclo virar sem o app ser aberto, 1 escudo é consumido automaticamente para salvar a ofensiva. Reset semanal progressivo (+1 escudo/semana).
* **Defesa Ativa (Modo Pausa):** Permite ativar manualmente o congelamento do estado corrente (limite de 4 por semana). O backend pausa as tarefas e impede a perda de escudos ou quebra de streak. Descansar é validado pelo sistema.

### 3. Matriz de Recompensa (Engine de XP em Modelagem)
* Criar Tarefa: `+5 XP` (Vencer a inércia)
* Criar Subtarefa: `+2 XP` (Estimular a organização)
* Concluir Subtarefa: `+10 XP` (Micro-recompensa)
* Concluir Tarefa Mãe: `+25 XP` (Fechamento de ciclo)
* **Level Up:** Calculado dinamicamente via backend através da fórmula: $XP_{Necessario} = Nivel \times 100$.

---

## 📊 Modelagem de Dados Inicial

* **`Usuario`**: ID, Nome, Email, Senha, XP_Total, Nivel, Escudos_Ativos, Pausas_Restantes_Semana, Streak_Atual.
* **`Tarefa`**: ID, Titulo, Descricao, Data_Criacao, Status (Enum), Porcentagem_Conclusao, Usuario_ID.
* **`Subtarefa`**: ID, Titulo, Concluida (Boolean), Tarefa_ID.
* **`Conquista`** & **`UsuarioConquista`**: Tabela de Badges com relacionamento `N:M` guardando o progresso para conquistas cumulativas (ex: *"Descansar também é uma tarefa"*).

---

## 🔒 Segurança e Configuração Local

O projeto utiliza **Variáveis de Ambiente** para gerenciar credenciais sensíveis de banco de dados, seguindo os padrões de mercado. Para rodar o projeto localmente, configure as seguintes variáveis na sua IDE ou sistema operacional:

```properties
spring.datasource.username=${DB_USERNAME:root}
spring.datasource.password=${DB_PASSWORD:sua_senha_local}
