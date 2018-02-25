from odoo import models, fields, api

class alumno(models.Model):
    _name = 'prueba.alumno'

    name = fields.Char()
    fecha_nacimiento = fields.Integer()
    description = fields.Text()
   