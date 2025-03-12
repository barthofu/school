module.exports = {
    moduleFileExtensions: ['js', 'ts'],
    transform: {
      '^.+\\.ts$': 'ts-jest'
    },
    setupFiles: [],
    transformIgnorePatterns: [
      '/node_modules/'
    ],
    testPathIgnorePatterns: [
      '__testUtils__'
    ],
    clearMocks: true,
    restoreMocks: true,
    testMatch: [
      '**/*.test.(js|ts)'
    ],
    roots: [
      '<rootDir>'
    ]
  }