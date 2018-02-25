# -*- coding: utf-8 -*-

from odoo import models, fields, api

class actor(models.Model):
    _name = 'cine.actor'

    name = fields.Char()
    edad = fields.Integer()