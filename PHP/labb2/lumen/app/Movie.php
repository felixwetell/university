<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Movie extends Model
{
  protected $fillable = [
    'id',
    'title',
    'year',
    'genre',
    'rating',
    'created_at',
    'updated_at',
  ];
}
