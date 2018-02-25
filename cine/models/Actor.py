# -*- coding: utf-8 -*-

from odoo import models, fields, api

class cine(models.Model):
    _name = 'cine.cine'

    name = fields.Char()
    edad = fields.Integer()