# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Magic Trade API — a RESTful backend for trading Magic: The Gathering cards between users. Built with Spring Boot 3.4.1 and Java 21, backed by PostgreSQL with Flyway migrations.

## Commands

```bash
# Run application
./mvnw spring-boot:run

# Build
./mvnw clean package

# Run all tests
./mvnw test

# Run a single test class
./mvnw test -Dtest=ClassName

# Run a single test method
./mvnw test -Dtest=ClassName#methodName
```

## Architecture

**Package root:** `api.trade.magic.magic_trade_api`

The project follows DDD with three main layers:

```
application/
  controller/        # REST controllers (currently only CardsController)
domain/
  entity/            # Domain entities (planned)
  service/           # Domain services (planned)
  exception/         # Custom exceptions (planned)
infra/
  entity/            # JPA entities: Card, User, Inventory, Offer, Transaction
  repository/        # Spring Data JPA repositories
config/              # Spring config beans (planned)
```

**Database:** PostgreSQL at `localhost:5432/mtg_trade_api`. Credentials in `src/main/resources/application.yml`. Schema is managed exclusively via Flyway migrations in `src/main/resources/db/migration/` — `ddl-auto` is set to `none`.

**Domain model:**
- `Card` — MTG card metadata (name, rarity, set code, base price, image URL)
- `User` — trader account with balance
- `Inventory` — join table for user↔card ownership (unique constraint on user_id + card_id)
- `Offer` — seller lists a card for sale with quantity and unit price
- `Transaction` — completed trade record linking buyer, seller, offer

All primary keys are UUIDs. Foreign key relationships use lazy loading. V5 migration adds performance indexes on FK columns and status fields.

## Development Rules

From `docs/COPILOT_INSTRUCTIONS.md`:
- **Suggest before creating** — propose new files/docs, wait for confirmation before creating
- **Edit only what is requested** — suggest improvements to other files separately
- **Show what will be done before doing it** — confirm before executing significant changes

## Conventions

- Use Lombok (`@Data`, `@Getter`, `@Setter`, `@Builder`, etc.) wherever possible
- Validation via `@Valid` and Jakarta Bean Validation annotations
- Centralized exception handling (to be implemented in `domain/exception/`)
- No data redundancy in the database schema

## Current Status

| Layer | Status |
|---|---|
| Database migrations (V1–V5) | Done |
| JPA Entities | Done |
| Repositories | Done |
| DTOs | Next |
| Domain Services | Next |
| Controllers (beyond Cards) | Next |
| Validation | Next |
| Tests | Next |
