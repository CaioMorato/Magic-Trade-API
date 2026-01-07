# COPILOT_INSTRUCTIONS

## Regras de Trabalho

### Documentação
- Sugerir criação ANTES de criar
- Aguardar aprovação do usuário
- Não criar automaticamente

### Edições de Arquivo
- Editar APENAS o solicitado
- Sugerir melhorias em outros arquivos
- Mostrar O QUÊ será feito antes de executar
- Aguardar confirmação

### Abordagem
- Menos documentação, mais ação
- Direto ao ponto
- Usuário no controle total

## Stack Técnico

- **Framework:** Spring Boot 3.4.1
- **Java:** 21
- **Database:** PostgreSQL (localhost:5432)
- **ORM:** JPA/Hibernate
- **Migration:** Flyway
- **Build:** Maven
- **Package Root:** `api.trade.magic.magic_trade_api`

## Estrutura de Pacotes

```
api/trade/magic/magic_trade_api/
├── application/
│   └── controller/
├── domain/
│   ├── entity/
│   ├── service/
│   └── exception/
├── infra/
│   ├── entity/
│   └── repository/
└── config/
```

## Status Atual

- **Database:** ✅ Corrigido (V1-V5 completo)
- **Entities:** ✅ Corrigido (Inventory, Offer, Transaction ajustadas)
- **Repositories:** ✅ Pronto
- **DTOs:** ⏳ Próximo
- **Domain Layer:** ⏳ Próximo
- **Controllers:** ⏳ Próximo
- **Validation:** ⏳ Próximo
- **Tests:** ⏳ Próximo

## Notas

- Usar Lombok quando possível
- Validação com `@Valid` e `javax.validation.*`
- Exception handling centralizado
- DDD como padrão arquitetural
- Sem redundância de dados no BD

