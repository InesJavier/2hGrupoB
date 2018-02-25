# -*- coding: utf-8 -*-

from odoo import models, fields, api
from datetime import timedelta,date,datetime

class director(models.Model):
    _name = 'cine.director'


    name = fields.Char()
    Fecha_Nacimiento = fields.Date()
    Edad = fields.Integer()
    value2 = fields.Float(compute="_value_pc", store=True)
    description = fields.Text()

    fechaActual=datetime.now()

    @api.depends('Fecha_Nacimiento')
    def _value_pc(self):
        diferencia=self.fechaActual-self.Fecha_Nacimiento
        self.Edad = diferencia.days/365