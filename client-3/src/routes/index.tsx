import React from 'react';
import { BrowserRouter, Switch, Route } from 'react-router-dom';

// Pages
import Main from '../pages/Main';
import Dockerfiles from '../pages/Dockerfiles';

const Routes: React.FC = () => {
  return (
    <BrowserRouter>
      <Switch>
        <Route exact path='/' component={Main} />
        <Route path='/dockerfiles' component={Dockerfiles} />
      </Switch>
    </BrowserRouter>
  );
}

export default Routes;