import { passwordLoginSelector, submitLoginSelector, usernameLoginSelector } from '../../support/commands';
import {
  entityCreateButtonSelector,
  entityCreateSaveButtonSelector,
  entityDeleteButtonSelector,
  entityConfirmDeleteButtonSelector,
} from '../../support/entity';

describe('Tests E2E Propios', () => {
  // Limpieza inicial del sessionStorage
  before(() => {
    cy.window().then(win => {
      win.sessionStorage.clear();
    });
    cy.visit('');
  });

  // Test de Login Incorrecto
  describe('Login Incorrecto', () => {
    before(() => {
      cy.visit('');
    });

    it('debe aparecer un cartel por las credenciales incorrectas', () => {
      cy.clickOnLoginItem();
      cy.get(usernameLoginSelector).click().type('admin');
      cy.get(passwordLoginSelector).type('pepe');
      cy.get(submitLoginSelector).click();
      cy.contains('Failed to sign in! Please check your credentials and try again.').should('be.visible');
    });
  });

  // Tests relacionados a Publisher
  describe('Publisher', () => {
    beforeEach(() => {
      cy.intercept('POST', '/api/publishers').as('createRequest');
      cy.intercept('DELETE', '/api/publishers/*').as('deleteRequest');      
      cy.login('admin', 'admin');
      cy.visit('');
    });

    it('debe crear un nuevo publisher', () => {
      cy.clickOnEntityMenuItem('publisher');
      cy.get(entityCreateButtonSelector).click();
      cy.get('[data-cy="name"]').type('publisher_test').should('have.value', 'publisher_test');
      cy.get(entityCreateSaveButtonSelector).click();

      cy.wait('@createRequest').then(({ response }) => {
        expect(response.statusCode).to.equal(201);
      });
    });

    it('debe eliminar un publisher existente', () => {
      cy.clickOnEntityMenuItem('publisher');
      cy.get(entityDeleteButtonSelector).last().click();
      cy.get(entityConfirmDeleteButtonSelector).click();

      cy.wait('@deleteRequest').then(({ response }) => {
        expect(response.statusCode).to.equal(204);
      });
    });
  });

  // Tests relacionados a Usuarios
  describe('Usuario', () => {
    beforeEach(() => {
      cy.intercept('POST', '/api/admin/users').as('createRequest');
      cy.intercept('DELETE', '/api/admin/users/*').as('deleteRequest');
      cy.login('admin', 'admin');
      cy.visit('');
    });

    it('debe crear un nuevo usuario', () => {
      cy.clickOnAdminMenuItem('user-management');
      cy.contains('Create a new user').click();

      cy.get('input[name="login"]').type('user_test').should('have.value', 'user_test');
      cy.get('input[name="firstName"]').type('User').should('have.value', 'User');
      cy.get('input[name="lastName"]').type('Test').should('have.value', 'Test');
      cy.get('input[name="email"]').type('usertest@localhost.com').should('have.value', 'usertest@localhost.com');
      cy.contains('Save').click();

      cy.wait('@createRequest').then(({ response }) => {
        expect(response.statusCode).to.equal(201);
      });
    });

    it('debe eliminar un usuario existente', () => {
      cy.clickOnAdminMenuItem('user-management');
      cy.contains('td', 'user_test')
        .parent()
        .find('button')
        .contains('Delete')
        .click();

      cy.get('.modal').within(() => {
        cy.contains('button', 'Delete').click();
      });

      cy.wait('@deleteRequest').then(({ response }) => {
        expect(response.statusCode).to.equal(204);
      });
    });
  });
});
