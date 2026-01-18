# DressUpTheLlama-Game

**DressUpTheLlama-Game** is an interactive Java Swing application that allows users to style a llama character with various outfits and accessories. This project demonstrates Object-Oriented Programming principles and specifically implements the **Bridge Design Pattern**.

## Description

In this game, the player selects a Llama character and applies different styles. The application separates the character logic from the clothing logic, allowing them to vary independently. Users can choose preset outfits (Glam, Emo, Pikachu) or customize individual pieces (Hats, Tops, Shoes, Accessories).

## Design Pattern: The Bridge Pattern

The core architectural pattern used in this project is the **Bridge Pattern**. This pattern decuples an abstraction from its implementation so that the two can vary independently.

### How it is implemented:

1.  **Abstraction (`Lama.java`)**:
    * Represents the high-level control layer. It holds a reference to the `OutfitImplementor` interface.
    * It delegates the styling work to the implementor object via the `applyOutfit` method.

2.  **Refined Abstraction (`lama1.java`, `lama2.java`)**:
    * These are concrete extensions of the `Lama` class.
    * They define specific llama characters (different base skins) but still rely on the bridge to handle the clothing logic.

3.  **Implementor (`OutfitImplementor.java`)**:
    * This interface defines the low-level operations for applying clothes (`apply` method).

4.  **Concrete Implementors (`Outfit1.java`, `Outfit2.java`, `Outfit3.java`)**:
    * These classes provide specific implementations for different styles:
        * **Outfit1**: Glam Style
        * **Outfit2**: Emo Style
        * **Outfit3**: Pikachu Style

### Helper Classes
* **`CustomizePanelBuilder.java`**: A utility class used to construct the intricate "Customize" UI panel, keeping the main GUI class cleaner.

## Features

* **Character Selection**: Choose between two different Llamas.
* **Preset Outfits**: One-click styling with full themed sets.
* **Customization Mode**: Mix and match hats, tops, shoes, and accessories individually.
* **Visual Feedback**: Real-time updates using Java Swing components (`JLabel`, `JLayeredPane`).
* **Responsive UI**: The layout adjusts to keep the game area square.


## 📂 Project Structure

```text
Proiect/
├── DressUpGameGUI.java       # Main entry point and UI orchestration
├── Lama.java                 # Abstraction (Abstract Class)
├── lama1.java                # Refined Abstraction 1
├── lama2.java                # Refined Abstraction 2
├── OutfitImplementor.java    # Implementor (Interface)
├── Outfit1.java              # Concrete Implementor (Glam)
├── Outfit2.java              # Concrete Implementor (Emo)
├── Outfit3.java              # Concrete Implementor (Pikachu)
└── CustomizePanelBuilder.java# UI Helper for customization menu