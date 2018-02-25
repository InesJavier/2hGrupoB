# -*- coding: utf-8 -*-

from odoo import models, fields, api

class Pais(models.Model):
    _name = 'cine.actor'

    name = fields.Char()
    