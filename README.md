# HarbourEats Quests Project RFC

## Context
HarbourEats, a prominent food delivery company, seeks to bolster courier engagement through the implementation of Quests. Quests are designed to incentivize couriers by offering rewards based on the completion of specific delivery milestones.

## API Design
- `POST /quests/{questId}/join`: Subscribe a courier to a specific Quest.
- `GET /quests/active`: Retrieve a list of ongoing Quests available to couriers.
- `GET /quests/history`: Retrieve a history of completed Quests for a courier.
- `GET /quests/{questId}/details`: Retrieve details of a specific Quest, including description, courier's progress within a specific Quest, including current tier, orders completed, and orders remaining, duration, and reward tiers.

We assume that the identification information about the courier is contained in cookie files, and the number of completed orders changes according to tracking in the HarbourEats delivery app.


## Requests
To retrieve a list of active quests:
```bash
curl http://localhost:8888/v1/quests/active
```

To retrieve the history of completed quests:
```bash
curl http://localhost:8888/v1/quests/history
```

To retrieve details of a specific quest by its name:
```bash
curl http://localhost:8888/v1/quests/name/details
```
