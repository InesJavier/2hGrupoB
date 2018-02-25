# -*- coding: utf-8 -*-

from odoo import models, fields, api

class pelicula(models.Model):
    _name = 'cine.pelicula'

    name = fields.Char()
    description = fields.Text()
    idirector = fields.Many2one('cine.director',String="director")
