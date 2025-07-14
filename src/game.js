const config = {
    type: Phaser.AUTO,
    width: 800,
    height: 600,
    parent: 'game-container',
    scene: {
        preload: preload,
        create: create,
        update: update
    }
};

const game = new Phaser.Game(config);

function preload() {
    // Load assets here later (e.g., board image, tokens)
}

function create() {
    // Draw a simple green board
    const board = this.add.rectangle(400, 300, 500, 500, 0x00ff00);
    
    // Player token (red circle)
    const player = this.add.circle(50, 550, 10, 0xff0000);
    
    // Dice roll button
    const rollButton = this.add.text(650, 50, 'Roll Dice', {
        fontSize: '24px',
        color: '#ffffff',
        backgroundColor: '#000000',
        padding: { x: 10, y: 5 }
    }).setInteractive();
    
    rollButton.on('pointerdown', () => {
        const dice = Math.floor(Math.random() * 6) + 1 + Math.floor(Math.random() * 6) + 1;
        this.add.text(650, 100, `Rolled: ${dice}`, { fontSize: '20px', color: '#000000' });
        // Move player (simplified)
        player.x += dice * 20;
    });
}

function update() {
    // Game loop for animations (add later)
}